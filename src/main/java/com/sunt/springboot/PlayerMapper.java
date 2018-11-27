package com.sunt.springboot;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlayerMapper {

    @Select("SELECT * FROM player")
    List<Player> findAll();

    @Select("SELECT * FROM player where id = #{id}")
    List<Player> findId(int id);

    @Insert("insert into player(id,title) values (#{id},#{title})")
    public int addPlayer(PlayerInfo playerInfo);

    @Delete("delete from player where id = #{id}")
    public int deletePlayer(int id);

    @Update("update player set title=#{title} where id=#{id}")
    public int update(PlayerInfo playerInfo);
}
