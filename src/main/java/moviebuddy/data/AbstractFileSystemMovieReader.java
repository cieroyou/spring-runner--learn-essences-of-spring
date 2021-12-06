package moviebuddy.data;

import moviebuddy.ApplicationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;

public abstract class AbstractFileSystemMovieReader implements ResourceLoaderAware {
    private String metadata;
    private ResourceLoader resourceLoader;

    public String getMetadata() {
        return metadata;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource getMetadataResource() {
        return resourceLoader.getResource(getMetadata());
    }

    @Value("${movie.metatdata}")
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 빈이 초기화 될 때, 올바른 값인지 검증을 해준다.
        // 네트워크상의 자원을 읽어 처리할 수 있도록 확장성을 넓히기 위해 바꿈 (ClassLoader.getSystemResource() -> Resource 추상화)
        Resource resource = getMetadataResource();
        if(!resource.exists()) {
            throw new FileNotFoundException(metadata);
        }
        if(!resource.isReadable()) {
            throw new ApplicationException(String.format("cannot read to metadata. [%s]", metadata));
        }

    }

    @PreDestroy
    public void destroy() {

    }
}
