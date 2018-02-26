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
 * CollationRepository.java
 * 
 * @author Sidharth Mishra <sidmishraw@gmail.com>
 * @created Feb 26, 2018 1:01:43 PM
 */
package io.sidmishraw.basicdal.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import io.sidmishraw.basicdal.domain.Collation;

/**
 *
 * Qualified Name: io.sidmishraw.basicdal.repos.CollationRepository
 *
 */
public interface CollationRepository extends Repository<Collation, String> {
    
    /**
     * Finds the collation object for the given collation name.
     * 
     * @param collationName
     *            The collation name.
     * 
     * @return The collation row.
     */
    @Query("SELECT c FROM Collation c where c.name = :collationName")
    Collation findCollationByName(@Param("collationName") String collationName);
    
    /**
     * Finds the collation key for the given collation name.
     * 
     * @param collationName
     *            The collation name.
     * 
     * @return The collation key.
     */
    @Query("SELECT c.key FROM Collation c where c.name = :collationName")
    String findKeyForName(@Param("collationName") String collationName);
    
    /**
     * Finds the collation name for the given collation key.
     * 
     * @param collationKey
     *            The collation key.
     * 
     * @return The collation name.
     */
    @Query("SELECT c.name FROM Collation c where c.key = :collationKey")
    String findNameForKey(@Param("collationKey") String collationKey);
}
