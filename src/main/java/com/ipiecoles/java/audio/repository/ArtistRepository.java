package com.ipiecoles.java.audio.repository;

import com.ipiecoles.java.audio.Model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Artist findOneByName(String name);

    Page<Artist> findByNameContaining(String name, Pageable pageable);
}
