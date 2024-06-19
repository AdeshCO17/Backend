package com.adeshcoder.Backingfor30mincoding.ServiceImp;

import com.adeshcoder.Backingfor30mincoding.Entities.Guide2;
import com.adeshcoder.Backingfor30mincoding.Services.Guide2Service;
import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;
import com.adeshcoder.Backingfor30mincoding.repositories.Guide2Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Guide2ServiceImpl  implements Guide2Service {
    @Autowired
    private Guide2Repo guideRepo;
    @Override
    public Guide2 createGuide(GuideDto guideDto) {

        Guide2 guide=new Guide2(guideDto.getTopic(),guideDto.getLink());
        return guideRepo.save(guide);
    }

    @Override
    public Guide2 updateGuide(Integer guideId, GuideDto guideDto) {

        Guide2 entity= this.guideRepo.findById(guideId).orElseThrow();
        entity.setTopic(guideDto.getTopic());
        entity.setLink(guideDto.getLink());

        return this.guideRepo.save(entity);
    }

    @Override
    public void DeleteGuide(Integer guideId) {

        Guide2 entity=this.guideRepo.findById(guideId).orElseThrow();
        guideRepo.delete(entity);

    }

    @Override
    public List<Guide2> getAllGuide() {
        return this.guideRepo.findAll();
    }

    @Override
    public Guide2 getGuide(Integer guideId) {
        return guideRepo.findById(guideId).orElseThrow();
    }
}
