package pl.indexpz.iStat.startup;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
public class DataLoader {

    private final List<Loader> loaders;

    public DataLoader(List<Loader> loaders) {
        this.loaders = loaders;
    }

    @PostConstruct
    public void loadData() {
        log.debug("Loading data");
        loaders.sort(Comparator.comparing(Loader::getPriority));
        for (Loader loader : loaders) {
            log.debug("Loading data for: {}", loader.getEntityName());
            Set<Long> createdIds = loader.createEntities();
            log.debug("Created {} {} entities with ids: {}",
                    createdIds.size(),
                    loader.getEntityName(),
                    createdIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
    }
}
