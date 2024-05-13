package io.spring.swagger.domain.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

@Mapper
public interface MemberRepository {

    Member findById(int id) throws DataAccessException;

    int save(Member member) throws DataAccessException;
    
    int deleteAll() throws DataAccessException;
}
