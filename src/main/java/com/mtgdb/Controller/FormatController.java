package com.mtgdb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtgdb.Entity.Format;
import com.mtgdb.Respository.FormatRepository;
import com.mtgdb.Respository.SetRepository;

@RestController
@RequestMapping(path = "/mtgdb")
public class FormatController {

	
	@Autowired
	private FormatRepository formatRepository;
	@Autowired
	private SetRepository setRepository;
	
	@GetMapping("/formats")
	public ResponseEntity<?> getFormats() {
		return ResponseEntity.ok(formatRepository.findAll());
	}
	
	@GetMapping("/format")
	public ResponseEntity<?> getFormat(@PathVariable Integer id) {
		return ResponseEntity.ok(formatRepository.findById(id));
	}
	
	@PostMapping("/formats")
	public Iterable<Format> postFormats(@RequestBody List<Format> formats) {
		return formatRepository.saveAll(formats);
	}
	
	@PostMapping("/format")
	public Format postFormat(@RequestBody Format format) {
		return formatRepository.save(format);
	}

	@PutMapping("/format/{formatId}")
	public void addSetsToFormats(@PathVariable Integer formatId, @RequestBody List<String> setsId) {
		Format f = formatRepository.findById(formatId).get();
		for (String setId: setsId) {
			f.addSet(setRepository.findById(setId).get());
			formatRepository.save(f);

		}
	}
}
