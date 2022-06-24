package com.project.bugtracker.BugTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.project.bugtracker.BugTracker.Entities.ProjectSequence;
import com.project.bugtracker.BugTracker.Entities.TicketSequence;
import com.project.bugtracker.BugTracker.Entities.UserEntity;
import com.project.bugtracker.BugTracker.Entities.userSequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
@Service
public class SequenceGenerator {
    
    @Autowired
    MongoOperations mongoOperations;

    public Integer usergenerateSequence(  String seqName){

        userSequence counter = mongoOperations.findAndModify(query(where("id").is(seqName)),
                new Update().inc("seqNo",1), options().returnNew(true).upsert(true),
                userSequence.class);
        
        return !Objects.isNull(counter) ? counter.getSeqNo() : 1;
    } 

    public Integer projectSequenceGenerator (String SequenceName){

        ProjectSequence projSeq = mongoOperations.findAndModify(query(where("id").is(SequenceName))
        , new Update().inc("seqNo", 1), options().returnNew(true).upsert(true)
        , ProjectSequence.class);

        return !Objects.isNull(projSeq) ? projSeq.getSeqNo() : 1;
    }

    public Integer ticketSequenceGenerator (String seqName){

        TicketSequence tSeq = mongoOperations.findAndModify(query(where("id").is(seqName))
        , new Update().inc("seqNo", 1), options().returnNew(true).upsert(true)
        , TicketSequence.class);

        return !Objects.isNull(tSeq) ? tSeq.getSeqNo() : 1;
    }
}
