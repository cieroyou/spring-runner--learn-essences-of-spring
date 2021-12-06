package moviebuddy.data;

import moviebuddy.ApplicationException;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public abstract class AbstractFileSystemMovieReader {
    private String metadata;

    public String getMetadata() {
        return metadata;
    }

    @Value("${movie.metatdata}")
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 빈이 초기화 될 때, 올바른 값인지 검증을 해준다.
        URL metadataUrl = ClassLoader.getSystemResource(getMetadata());
        if (Objects.isNull(metadataUrl)) {
            throw new FileNotFoundException(metadata);
        }
        if (!Files.isReadable(Path.of(metadataUrl.toURI()))) {
            throw new ApplicationException(String.format("cannot read to metadata. [%s]", metadata));
        }
    }

    @PreDestroy
    public void destroy() {

    }
}
