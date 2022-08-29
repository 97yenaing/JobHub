package cgmgl.springmvc.app.persistence.dao;

import cgmgl.springmvc.app.persistence.entity.Authority;

public interface AuthorityDao {
    
     public void dbSaveAuthority(Authority adminAuthority);

     public long dbGetAuthorityCount();
}
