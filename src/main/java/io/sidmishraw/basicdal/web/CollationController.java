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
 * CollationController.java
 * 
 * @author Sidharth Mishra <sidmishraw@gmail.com>
 * @created Feb 26, 2018 2:17:31 PM
 */
package io.sidmishraw.basicdal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.sidmishraw.basicdal.service.CollationService;

/**
 *
 * Qualified Name: io.sidmishraw.basicdal.web.CollationController
 *
 */
@RestController
public class CollationController {
    
    @Autowired
    private CollationService collationService;
    
    @RequestMapping(path = { "/" })
    public String hello() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("Hello and welcome to Collation service!</br>");
        buffer.append("</br></br>");
        buffer.append(
                "For getting the Collation key for given name, use the endpoint '/gck' with 'cname' parameter.</br>");
        buffer.append("</br></br>");
        buffer.append(
                "For getting the Collation name for given key, use the endpoint '/gcn' with 'ckey' parameter.</br>");
        buffer.append("</br></br>");
        buffer.append(
                "For getting the Collation object for given name, use the endpoint '/gc' with 'cname' parameter.</br>");
        
        return buffer.toString();
    }
    
    @RequestMapping(path = { "/gck" }, method = { RequestMethod.GET })
    public String getCollationKey(@RequestParam(name = "cname", required = true) String collationName) {
        return this.collationService.getCollationKeyForName(collationName);
    }
    
    @RequestMapping(path = "/gcn", method = { RequestMethod.GET })
    public String getCollationName(@RequestParam(name = "ckey", required = true) String collationKey) {
        return this.collationService.getCollationNameForKey(collationKey);
    }
    
    @RequestMapping(path = "/gc", method = { RequestMethod.GET })
    public String getCollation(@RequestParam(name = "cname", required = true) String collationName) {
        return this.collationService.getCollationForName(collationName);
    }
}
