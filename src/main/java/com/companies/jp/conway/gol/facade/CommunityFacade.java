package com.companies.jp.conway.gol.facade;

import com.companies.jp.conway.gol.model.Cell;
import com.companies.jp.conway.gol.model.Community;
import com.companies.jp.conway.gol.strategy.ConwaysEvolution;
import com.companies.jp.conway.gol.strategy.IEvolution;
import com.companies.jp.conway.gol.strategy.ILife;
import java.util.Set;

/*
Community Facade hides complexities of life evolution and
provides an interface to generate life.
 */
public class CommunityFacade {

    private Community community;
    private ILife life;

    public CommunityFacade() {
        community = new Community();
    }

    public void initiateLife(ILife life) {
        this.life = life;
        community.setCommunityGrid(life.birth());
        community.buildCommunity();
    }

    public void nextLife() {
        IEvolution evolution = new ConwaysEvolution();
        community.setEvolution(evolution);
        community.runEvolution();
    }

}
