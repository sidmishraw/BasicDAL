/**
 * 
 * BSD 3-Clause License
 * 
 * Copyright (c) 2018, Sidharth Mishra
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * * Neither the name of the copyright holder nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS AS IS
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 * CollationServiceImpl.java
 * 
 * @author Sidharth Mishra <sidmishraw@gmail.com>
 * @created Feb 26, 2018 2:11:24 PM
 */
package io.sidmishraw.basicdal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sidmishraw.basicdal.repos.CollationRepository;
import io.sidmishraw.basicdal.service.CollationService;

/**
 *
 * Qualified Name: io.sidmishraw.basicdal.service.impl.CollationServiceImpl
 *
 */
@Service
@Component("collationService")
public class CollationServiceImpl implements CollationService {
    
    @Autowired
    private CollationRepository collationRepository;
    
    /*
     * (non-Javadoc)
     * 
     * @see io.sidmishraw.basicdal.service.CollationService#getCollationNameForKey(java.lang.String)
     */
    @Override
    public String getCollationNameForKey(String collationKey) {
        return this.collationRepository.findNameForKey(collationKey);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see io.sidmishraw.basicdal.service.CollationService#getCollationKeyForName(java.lang.String)
     */
    @Override
    public String getCollationKeyForName(String collationName) {
        return this.collationRepository.findKeyForName(collationName);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see io.sidmishraw.basicdal.service.CollationService#getCollationForName(java.lang.String)
     */
    @Override
    public String getCollationForName(String collationName) {
        try {
            return new ObjectMapper().writeValueAsString(this.collationRepository.findCollationByName(collationName));
        } catch (Exception e) {
            return null;
        }
    }
    
}
