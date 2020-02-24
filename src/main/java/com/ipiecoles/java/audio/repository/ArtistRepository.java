package com.ipiecoles.java.audio.repository;

import com.ipiecoles.java.audio.Model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Page<Artist> findByName(String name, Pageable pageable);
}
