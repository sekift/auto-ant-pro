package com.ant.auto.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sekift
 */
public abstract class ReloadableProperties {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
			
	private static ScheduledExecutorService service = ThreadPools.newScheduledExecutorService(1,
			"ReloadThread(AbstractReloadableProperties)");
 
	protected Map<String, Object> props = new ConcurrentHashMap<>(100);
	
	private URL src = null;
	
	private String protocol = null;
	
	private File targetSrc = null;
			
	private long lastModifiedTime = 0;
	
	private long jarLastModifiedTime = 0;
	
	private boolean timingReload = false;
		
	public <T> T getValue(Object key) {
		return (T)props.get(key);
	}
	
	public final boolean getTimingReload() {		
		return timingReload;
	}
	
	public final void setTimingReload(boolean flag) {		
		timingReload = flag;
	}
		
	protected abstract URL getSourceURL();

	/**
	 * default 15s
	 *
	 * @return
	 */
	protected long getScanInterval() {		
		return 15 * 1000L;
	}
	
	@SuppressWarnings({"rawtypes"})
	protected abstract Map reload(InputStream in, Map tarStorage);
		
	public final void initialize() {
		
		logger.info("Begin Init Properties File[{}], Execute Class[{}]", this.getSourceURL(), this.getClass().getName());		
		src = getSourceURL();
		if (null == src) {
			String errorMsg = "Can not find the properties file, The properties object is null";
			logger.error(errorMsg);
			throw new RuntimeException(errorMsg);
		}
		
		protocol = src.getProtocol();
		if ("file".equals(protocol)) { 
			targetSrc = new File(src.getPath()); 
			lastModifiedTime = targetSrc.lastModified();
			try (FileInputStream fin = new FileInputStream(targetSrc)) {
				props = reload(fin, props);
			} catch (Exception iex) {
				throw new RuntimeException("Reload properties exception", iex);
			}
		} else if ("jar".equals(protocol)) {
			String[] info = src.getPath().split("\\!");
			targetSrc = new File(info[0].substring(5)); 
			lastModifiedTime = targetSrc.lastModified();
			try (JarFile jf = new JarFile(targetSrc, false, ZipFile.OPEN_READ)) {
				ZipEntry ze = jf.getEntry(info[1].substring(1));
				jarLastModifiedTime = ze.getTime();
				props = reload(jf.getInputStream(ze), props);
			} catch (Exception ex) {
				throw new RuntimeException("Create jar file exception", ex);
			}
		}
			
		long interval = getScanInterval();
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {  
					long lmt = targetSrc.lastModified(); 
					if (0 == lmt) {
						logger.error("URL[{}]is not found", targetSrc); 
						return;
					}
					if(lastModifiedTime < lmt || 0 == lastModifiedTime) {
						lastModifiedTime = lmt;
						logger.debug("The properties is change[{}]", targetSrc); 	
						if ("file".equals(protocol)) { 
							logger.debug("Use the filesystem to load properties direct");
							try (FileInputStream fin = new FileInputStream(targetSrc)) {
								logger.debug("Use file stream, reload the properties begin...");
								props = reload(fin, props);
								logger.debug("Use file stream, reload the properties over");
							} catch (Exception iex) {
								logger.error("Reload properties exception, iex:{}", iex);
							}
						} else if ("jar".equals(protocol)) {
							logger.debug("Use jar to load properties");
							String[] info = src.getPath().split("\\!");
							try (JarFile jf = new JarFile(targetSrc, false, ZipFile.OPEN_READ)) {
								ZipEntry ze = jf.getEntry(info[1].substring(1));
								long jlmt = ze.getTime();
								if (jarLastModifiedTime < jlmt || 0 == jarLastModifiedTime) {
									jarLastModifiedTime = jlmt;
									logger.debug("Use jar's ZipEntry stream, reload the properties begin...");
									props = reload(jf.getInputStream(ze), props);
									logger.debug("Use jar's ZipEntry stream, reload the properties over");
								}
							} catch (Exception ex) {
								throw new RuntimeException("Create jar file exception", ex);
							}
						}
					}
				} catch (Exception ex) {
					logger.error("The schedule task exception cause from reload the properties check. ex:{}", ex);
				}				
				if (timingReload) {
					long interval = getScanInterval();
					service.schedule(this, interval, TimeUnit.MILLISECONDS);
				}
			}				
		};
		service.schedule(task, interval, TimeUnit.MILLISECONDS); 
	}

	public Map<String, Object> getProperties() {
		return this.props;
	}
}
