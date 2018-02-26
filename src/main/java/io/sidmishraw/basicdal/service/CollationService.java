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
 * CollationService.java
 * 
 * @author Sidharth Mishra <sidmishraw@gmail.com>
 * @created Feb 26, 2018 1:09:26 PM
 */
package io.sidmishraw.basicdal.service;

/**
 *
 * Qualified Name: io.sidmishraw.basicdal.service.CollationService
 *
 */
public interface CollationService {
    
    /**
     * Gets the collation name for the given collation key.
     * 
     * @param collationKey
     *            The collation key.
     * 
     * @return The collation name.
     */
    String getCollationNameForKey(String collationKey);
    
    /**
     * Gets the collation key for the given collation name.
     * 
     * @param collationName
     *            The collation name.
     * 
     * @return The collation key.
     */
    String getCollationKeyForName(String collationName);
    
    /**
     * Gets the JSON string representation of a collation object for the given collation name.
     * 
     * @param collationName
     *            The collation name.
     * 
     * @return The JSON string representation of the collation object.
     */
    String getCollationForName(String collationName);
}