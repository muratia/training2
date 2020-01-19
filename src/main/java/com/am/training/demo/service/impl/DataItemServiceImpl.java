package com.am.training.demo.service.impl;

import com.am.training.demo.entity.DataItem;
import com.am.training.demo.exception.DataItemNotFoundException;
import com.am.training.demo.repository.DataItemRepository;
import com.am.training.demo.service.DataItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;



@Service
@Transactional
/**
 *  Data Item Service Implementation
 * @implNote DataItemService
 */
public class DataItemServiceImpl implements DataItemService {

    private final Logger logger = LoggerFactory.getLogger(DataItemServiceImpl.class);
    private final DataItemRepository repository;


    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("training_0.0.1-SNAPSHOTPU");

    @PersistenceContext
    private EntityManager em;

    @Autowired
    /**
        Constructor of the Service implementation
     */
    public DataItemServiceImpl(DataItemRepository repository) {
        this.repository = repository;
    }


    /**
     *  Creates the instance of the Entity Manager
     * @return EntityManager
     */
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * This method returns the Entity selected based in the passed parameter id
     * @param id Integer
     * @return DataItem
     * @throws DataItemNotFoundException
     */
    @Override

    public DataItem find(Integer id) throws DataItemNotFoundException {
        DataItem DataItem;

        Optional<DataItem> optionalDataItem = repository.findById(id);
        if (optionalDataItem.isPresent()) {
            DataItem = optionalDataItem.get();
        } else {
            throw new DataItemNotFoundException("Data not found ");
        }
        return DataItem;
    }

    @Override
    public DataItem save(DataItem DataItem) {
        return repository.save(DataItem);
    }


    @Override
    public List<DataItem> findDataItems() {
        return repository.findAll();
    }

    @Override
    public void save(List<DataItem> DataItems) {
        logger.debug("Received Data Rows: \n" + Arrays.deepToString(DataItems.toArray()));
          repository.saveAll(DataItems);
    }

    @Override
    public String getMostTalksPerYear(LocalDate start, LocalDate end) {

        String name = null;

        try {

            em = getEntityManager();
            String queryStr = "SELECT d.redner FROM DataItem d WHERE d.datum BETWEEN '" +
                    start + "' AND '" + end + "' GROUP BY redner HAVING MAX(d.thema)> MIN(d.thema)";
            logger.info("Query 1: " + queryStr);
            Query query = em.createNativeQuery(queryStr);

            name = (String) query.getSingleResult();
        } catch (Exception ex) {
            logger.info("Talks per year: " + ex.getMessage());
        }
        return name;
    }

    @Override
    public String getTheTalkerByTopic(String topic) {

        if (topic.isEmpty()) {
            logger.info("Empty topic");
            return null;
        }
        String name = null;

        String queryStr = "SELECT d.`redner` FROM DataItem d WHERE  d.`thema`='" + topic + "' GROUP BY d.`redner` ORDER  BY COUNT(*) DESC";

        try {
            em = getEntityManager();
            Query query = em.createNativeQuery(queryStr);
            name = (String) query.getSingleResult();
        } catch (Exception ex) {
            logger.info("Topic: " + ex.getMessage());
        }
        return name;
    }

    @Override
    public String getTheMinimalWordsPerTalk() {
        logger.info("Least words per talk");
        String name = null;
        try {
            String queryStr = "SELECT d.redner from DataItem d ORDER BY d.`woerter` ASC LIMIT 1";

            em = getEntityManager();

            Query query = em.createNativeQuery(queryStr);
            name = (String) query.getSingleResult();
        } catch (Exception ex) {
            logger.info("Least words per talk: " + ex.getMessage());
        }

        return name;
    }
}
