/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necl.service;

import com.necl.model.ConfigSystem;

/**
 *
 * @author C13.207
 */
public interface ConfigSystemService {
    public ConfigSystem findByKey(String key) throws Exception;
    public boolean update(ConfigSystem configSystem) throws Exception;
}
