package com.ipiecoles.java.audio.repository;
import com.ipiecoles.java.audio.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlbumRepository extends JpaRepository<Album, Integer> {



}
