package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.Model.Artist;
import com.ipiecoles.java.audio.repository.AlbumRepository;
import com.ipiecoles.java.audio.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artist findById(
            @PathVariable(value = "id") Long id
    ){
        return artistRepository.findById(id).get();
    }

    @RequestMapping(params = "name",method = RequestMethod.GET)
//    @GetMapping
    public Page<Artist> findByName(
            @RequestParam("name") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        return artistRepository.findByName(name,PageRequest.of(page,size));
    }

    @RequestMapping(value = "")
    public Page<Artist> listartists(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortProperty", defaultValue = "name") String sortProperty,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection
    ){
        return artistRepository.findAll(PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortProperty));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Artist createArtist(@RequestBody Artist artist){
        return artistRepository.save(artist);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Artist updateArtist(
            @RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtiste(
            @PathVariable("id") Long idArtist
    ){
        artistRepository.delete(findById(idArtist));
    }
}
