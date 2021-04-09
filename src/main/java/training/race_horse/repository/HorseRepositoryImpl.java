package training.race_horse.repository;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import training.race_horse.model.Account;
import training.race_horse.model.Horse;
import training.race_horse.model.Trainer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HorseRepositoryImpl implements HorseRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Horse> findAllByTrainerId(Long id, String name) {
        String jpql = "select h from Horse h " +
                "inner join h.accounts a " +
                "inner join Trainer t on t.account = a " +
                "where t.id = :trainerId ";

        if (!StringUtils.isEmpty(name)){
//            jpql += "and h.name = :horseName";
            jpql += "and h.name like :horseName";

        }
        TypedQuery<Horse> query = entityManager.createQuery(jpql, Horse.class);
        query.setParameter("trainerId", id);
        query.setParameter("horseName", String.format("%%%s%%", name));

        return query.getResultList();
    }
//    @Override
//    public List<Account> findAllByTrainerId(Set<Long> ids) {
//        String query = "select t.account from Trainer t where t.id in (:ids)";
//
//        TypedQuery<Account> abc = entityManager.createQuery(query, Account.class);
//        if (!CollectionUtils.isEmpty(ids)) {
//            abc.setParameter("ids", ids);
//        }
//
//        return abc.getResultList();
//    }
}
