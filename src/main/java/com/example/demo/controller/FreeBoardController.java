package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.collection.Paging;
import com.example.demo.service.FreeBoardService;
import com.example.demo.service.FreeComentService;
import com.example.demo.vo.FreeBoardVO;
import com.example.demo.vo.FreeComentVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeboardService;
	@Autowired
	private FreeComentService freeComentService;
	
	@PostMapping("/freeboard")
	public Integer insertFree(@Valid @RequestBody FreeBoardVO freeVo) {
		return freeboardService.insertFree(freeVo);
	}
	
	@PutMapping("/freeboard")
	public Integer updateFree(@Valid @RequestBody FreeBoardVO freeVo) {
		return freeboardService.updateFree(freeVo);
	}
	
	@DeleteMapping("/freeboard")
	public Integer deleteFree(@RequestBody FreeBoardVO freeVo) {
		return freeboardService.deleteFree(freeVo);
	}
	
	@GetMapping("/freeboard/{fre_no}")
	public FreeBoardVO freeView(@PathVariable Integer fre_no) {
		//like unlike count
		//조회수 중복 방지 캐시필요
		return freeboardService.freeView(fre_no);
	}
	
	@GetMapping("/freeboard")
	public List<FreeBoardVO> freeListView(FreeBoardVO freeVo, @RequestParam(value="clickBlock",required=false) Integer clickBlock){
		freeVo.setPaging(new Paging());
		freeVo.getPaging().setClickBlock(clickBlock==null?0:clickBlock);
		return freeboardService.freeListView(freeVo);
	}
	
	/* reply */
	
	@PostMapping("/freereply")
	public Integer insertFreeReply(@Valid @RequestBody FreeComentVO freeComentVo) {
		return freeComentService.insertFreeComent(freeComentVo);
	}
	
	@PutMapping("/freereply")
	public Integer updateFreeReply(@Valid @RequestBody FreeComentVO freeComentVo) {
		return freeComentService.updateFreeComent(freeComentVo);
	}
	
	@DeleteMapping("/freereply")
	public Integer deleteFreeReply(@RequestBody FreeComentVO freeComentVo) {
		return freeComentService.deleteFreeComent(freeComentVo);
	}
	
}
