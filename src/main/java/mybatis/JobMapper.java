package mybatis;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer jobId);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer jobId);

    List<Job> selectAll();

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}