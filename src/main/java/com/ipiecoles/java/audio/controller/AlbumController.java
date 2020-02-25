package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.Model.Album;
import com.ipiecoles.java.audio.repository.AlbumRepository;
import com.ipiecoles.java.audio.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(params = {"idArtist", "titleAlbum"}, method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addAlbumOfArtist(
            @PathVariable("idArtist") Integer idArtist,
            @PathVariable("titleAlbum") String titleAlbum
    ){
        Album album = new Album();
        album.setTitle(titleAlbum);
        //album.setArtistId(idArtist);
    }
}
