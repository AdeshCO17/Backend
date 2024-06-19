package com.adeshcoder.Backingfor30mincoding.ServiceImp;

import com.adeshcoder.Backingfor30mincoding.Entities.Guide1;
import com.adeshcoder.Backingfor30mincoding.Services.Guide1Serive;
import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;
import com.adeshcoder.Backingfor30mincoding.repositories.Guide1Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Guide1ServiceImpl implements Guide1Serive {

    @Autowired
    private Guide1Repo guide1Repo;

    @Override
    public Guide1 createGuide(GuideDto guideDto) {

        Guide1 guide=new Guide1(guideDto.getTopic(),guideDto.getLink());
        return guide1Repo.save(guide);
    }

    @Override
    public Guide1 updateGuide(Integer guideId, GuideDto guideDto) {

        Guide1 entity= this.guide1Repo.findById(guideId).orElseThrow();
        entity.setTopic(guideDto.getTopic());
        entity.setLink(guideDto.getLink());

        return this.guide1Repo.save(entity);
    }

    @Override
    public void DeleteGuide(Integer guideId) {

        Guide1 entity=this.guide1Repo.findById(guideId).orElseThrow();
        guide1Repo.delete(entity);

    }

    @Override
    public List<Guide1> getAllGuide() {
        return this.guide1Repo.findAll();
    }

    @Override
    public Guide1 getGuide(Integer guideId) {
        return guide1Repo.findById(guideId).orElseThrow();
    }
}
