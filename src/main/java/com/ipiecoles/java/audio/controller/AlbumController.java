package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.Model.Album;
import com.ipiecoles.java.audio.exception.EntityConflictException;
import com.ipiecoles.java.audio.repository.AlbumRepository;
import com.ipiecoles.java.audio.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Album createAlbum(@RequestBody Album album) throws EntityConflictException {
        Album albumSearch = albumRepository.findByTitle(album.getTitle());
        if(albumSearch != null){
            throw new EntityConflictException("L'album existe déjà!");
        }
        return this.albumRepository.save(album);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable("id") Integer idAlbum){
        albumRepository.deleteById(idAlbum);
    }
}
