package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.StudentDemo;
import com.example.demo.Service.StudentService;

@RestController
public class StudentController {
	@Autowired 
         StudentService stuService;
	
	@PostMapping("/addDetails")
	
	public StudentDemo addInfo(@RequestBody StudentDemo st) {
		return stuService.savedetails(st);
	}
	@GetMapping("/showDetails")
	public List<StudentDemo>fetchDetails()
	{
		return stuService.getDetails();
	}
	@PutMapping("/UpdateDetails")
	public StudentDemo UpdateInfo(@RequestBody StudentDemo st1)
	{
		return stuService.updatedetails(st1);
	}
	@DeleteMapping("/delete/{sid}")
	public String deleteInfo(@PathVariable("sid") int sid)
	{
		stuService.deleteDetails(sid);
		return "Deleted details";
	}
}