package com.movierank.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.movierank.domain.MovieDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MongoDAO {
	
	@Autowired
	private MongoOperations mongoOper;
	// sqlSession같은 개념
	
	public void save(MovieDTO mDto) {
		log.info(">>>>> 영화 랭킹 정보 MongoDB에 저장");
		mongoOper.save(mDto);
	}
	
	public void dropCol() {
		log.info(">>>>> Collection Drop");
		mongoOper.dropCollection("movie");
	}
	
	public List<MovieDTO> movieList() {
		log.info(">>>>> 영화 랭킹정보 MongoDB에 저장");
		Criteria cri = new Criteria(); // key값
		// cri.is(value); value값 ㄴ위의 컬럼에서 아래에 있는 값을 다 찾아주라
		Query query = new Query(cri); 
		List<MovieDTO> list = mongoOper.find(query, MovieDTO.class, "movie"); // find()는 쿼리(조건)을 꼭 입력해줘야한다.
		for (MovieDTO one : list ) {
			log.info(one.toString());
		}
		return list;
	}

}
