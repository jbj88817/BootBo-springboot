package us.bojie.bootbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import us.bojie.bootbo.domain.Girl;
import us.bojie.bootbo.exception.GirlException;
import us.bojie.bootbo.repository.GirlRepository;

@Service
public class GirlService {

    @Autowired
    private GirlRepository mGirlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("C");
        girlA.setAge(18);
        mGirlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("Dddd");
        girlB.setAge(19);
        mGirlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = mGirlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(100, "You're at element");
        } else if (age > 10 && age < 16) {
            throw new GirlException(101, "You're at mid-school");
        }
    }
}
