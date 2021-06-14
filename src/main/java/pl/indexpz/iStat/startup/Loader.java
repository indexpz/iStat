package pl.indexpz.iStat.startup;

import java.util.Set;

public interface Loader {

    Integer getPriority();

    String getEntityName();

    Set<Long> createEntities();
}
