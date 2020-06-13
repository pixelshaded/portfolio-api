package com.alexanderfisher.portfolio.api.hibernate.hbm2java;

import org.hibernate.cfg.reveng.DefaultReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

public class CustomReverseEngineeringStrategy extends DefaultReverseEngineeringStrategy {
    @Override
    public String tableToClassName(TableIdentifier tableIdentifier) {
        return super.tableToClassName(tableIdentifier) + "Entity";
    }
}
