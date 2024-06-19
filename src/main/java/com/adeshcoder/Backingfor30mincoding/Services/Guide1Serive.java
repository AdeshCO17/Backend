package com.adeshcoder.Backingfor30mincoding.Services;

import com.adeshcoder.Backingfor30mincoding.Entities.Guide1;
import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;


import java.util.List;

public interface Guide1Serive {
    Guide1 createGuide(GuideDto guideDto);
    Guide1 updateGuide(Integer guideId, GuideDto guideDto);

    void DeleteGuide(Integer guideId);

    List<Guide1> getAllGuide();

    Guide1 getGuide(Integer guideId);
}
