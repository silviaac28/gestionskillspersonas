package com.agencia.skills.application;


import com.agencia.skills.domain.entity.Skill;
import com.agencia.skills.domain.service.SkillService;

public class CreateSkillUseCase {

    private final SkillService skillService;


    public CreateSkillUseCase(com.agencia.skills.domain.service.SkillService SkillService){
        this.skillService = SkillService;
    }

    public void execute(Skill skill){
        skillService.createSkill(skill);
    }

}
