package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    HashMap<Long,TimeEntry> rep= new  HashMap<Long,TimeEntry>();
    private long i=0;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id=++i;
        timeEntry.setId(id);
        rep.put(id,timeEntry);
        return timeEntry;

    }

    @Override
    public TimeEntry find(long id) {
        return rep.get(id);

    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(rep.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(rep.get(id)==null)  return null;
        timeEntry.setId(id);
        rep.put(id,timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long id) {
        rep.remove(id);
    }
}
