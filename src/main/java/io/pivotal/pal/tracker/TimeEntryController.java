package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository= timeEntryRepository;
    }

    public ResponseEntity create(TimeEntry timeEntryToCreate) {
         TimeEntry timeEntry=timeEntryRepository.create(timeEntryToCreate);
     return new ResponseEntity(timeEntry,HttpStatus.CREATED);

    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        TimeEntry timeEntry=timeEntryRepository.find(timeEntryId);
        if(timeEntry==null)  return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(timeEntry,HttpStatus.OK);

    }

    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> list=timeEntryRepository.list();
        return new ResponseEntity(list,HttpStatus.OK);

    }

    public ResponseEntity update(long timeEntryId, TimeEntry expected) {

        TimeEntry timeEntry=timeEntryRepository.update(timeEntryId,expected);
        if(timeEntry==null)  return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(timeEntry,HttpStatus.OK);
    }

    public ResponseEntity delete(long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
