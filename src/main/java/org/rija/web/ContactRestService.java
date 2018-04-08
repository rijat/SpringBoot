package org.rija.web;

import java.util.List;
import java.util.Optional;

import org.rija.dao.ContactRepository;
import org.rija.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestService {
	@Autowired
	private ContactRepository contactRepository;
	
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getContacts() {
		return contactRepository.findAll();		
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public Page<Contact> search(@RequestParam(name ="mc", defaultValue="") String mc,
								@RequestParam(name ="page", defaultValue="0") int page, 
								@RequestParam(name ="size", defaultValue="5")int size) {
		return contactRepository.search("%"+mc+"%", new PageRequest(page,size));		
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Optional<Contact> getContacts(@PathVariable Long id) {
		return contactRepository.findById(id);
	}
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact save(@RequestBody Contact c) {
		return contactRepository.save(c);
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		contactRepository.deleteById(id);
		return true;
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact upDate(@PathVariable Long id, @RequestBody Contact c) {
		c.setId(id);
		return contactRepository.save(c);
	}
	
	

}
