package com.multi.mvc.rest.controller;

import com.multi.mvc.rest.model.vo.Cat;
import com.multi.mvc.rest.service.CatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController : Rest 요청을 받는 Controller로 지칭하는 어노테이션,
//					무조건 REST 방식(=View를 사용하지 않음)으로 요청과 응답을 처리한다.
//					Handler method의 ResponseBody가 자동으로 붙는다.
//					Controller로 해도 기능상 문제는 없다.
//@RequestMapping : 최상위 리소스를 지칭하는 url, 현재는 /animal/cat(고양이) 정보만 다루는 REST로 가정

// postman 사용법 참고 블로그 : https://binit.tistory.com/17

// Swagger 참조 블로그
// https://twofootdog.github.io/Spring-Spring-MVC%EC%97%90-Swagger-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0/

@RequestMapping("/rest/cat")
@RestController
@Api(value = "CatRestController", tags = "고양이 정보")
public class CatRestController {

	@Autowired
	private CatService service;


	// 보안상 코드 다른 주소로부터 Ajax 요청을 거부하는 방법
	@ApiOperation(value = "고양이 정보 조회", notes = "고양이의 모든 정보를 반환")
	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	@GetMapping("") // @GetMapping : Rest에서 read할때 사용하는 어노테이션
	public ResponseEntity<List<Cat>> getCatAllInfo(
			@RequestParam(name = "name", required = false) String name
	){
        List<Cat> list;
        if(name == null) {
            list = service.selectAll();
        } else {
            list = service.selectByName(name);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	// /animal/cat/{id}
	@GetMapping("/{id}") // get 요청에서 path로 리소스 id를 가져오는 방법!, @PathVariable과 같이 사용!
	public ResponseEntity<Cat> getCatInfo(@PathVariable("id") int id){
		Cat cat = service.selectById(id);
		if(cat != null) {
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	@PostMapping("/form") // create 전용, 쓰기 용도
	// -> HTML에서 form으로 받올때 쓰는 방식! REST에서는 올바르지 않은 방식!
	public ResponseEntity<Cat> createCatForHtmlForm(Cat requestCat){
		int result = service.insertCat(requestCat);
		if(result > 0) {
			Cat cat = service.selectById(requestCat.getId());
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		}{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	// @RequestBody : json으로 구성되어 있는 요청 값을 객체로 변환하는 어노테이션, 언마샬링 전용
	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	// POST : /animal/cat/
	@PostMapping("") // create 전용, 쓰기 용도
	public ResponseEntity<Cat> createCat(@RequestBody Cat requestCat){
		int result = service.insertCat(requestCat);
		if(result > 0) {
			Cat cat = service.selectById(requestCat.getId());
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		}{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	// PUT : /animal/cat/{id}
	@PutMapping("/{id}") // put : update 할때 사용하는 어노테이션
	public ResponseEntity<Cat> updateCat(
			@PathVariable("id") int id, @RequestBody Cat requestCat){
		requestCat.setId(id);
		Cat cat = service.updateCat(requestCat);
		if(cat != null) {
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		}{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	// DELETE : /animal/cat/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cat> deleteCat(@PathVariable("id") int id){
		Cat cat = service.selectById(id);
		int result = service.deleteCat(id);
		if(result > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}


























