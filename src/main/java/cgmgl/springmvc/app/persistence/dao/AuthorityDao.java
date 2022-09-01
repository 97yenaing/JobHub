package cgmgl.springmvc.app.persistence.dao;

import cgmgl.springmvc.app.persistence.entity.Authority;

/**
 * <h2> AuthorityDao Class</h2>
 * <p>
 * Process for Displaying AuthorityDao
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
public interface AuthorityDao {
    
     /**
     * <h2> dbSaveAuthority</h2>
     * <p>
     * 
     * </p>
     *
     * @param adminAuthority
     * @return void
     */
    public void dbSaveAuthority(Authority adminAuthority);

     /**
     * <h2> dbGetAuthorityCount</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return long
     */
    public long dbGetAuthorityCount();
}
