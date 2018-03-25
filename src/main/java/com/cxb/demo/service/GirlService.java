package com.cxb.demo.service;

import com.cxb.demo.exception.GirlException;
import com.cxb.demo.enums.ResultEnum;
import com.cxb.demo.repository.GirlRepository;
import com.cxb.demo.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;
    //事物
    @Transactional
    public void insertTwo(){
        Girl girlA=new Girl();
        girlA.setCupSize("A1");
        girlA.setAge(28);
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setCupSize("B2");
        girlB.setAge(36);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl=girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<12){
            //返回你还在上小学  code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age>12 && age<16){
            //返回你在上初中  code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
