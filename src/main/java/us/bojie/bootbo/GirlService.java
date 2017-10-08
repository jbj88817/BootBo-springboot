package us.bojie.bootbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
