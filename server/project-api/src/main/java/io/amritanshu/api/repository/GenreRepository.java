package io.amritanshu.api.repository;

import io.amritanshu.api.entity.Genre;

public interface GenreRepository {
	
	public Genre findByName(String genreName);
	
	public Genre create(Genre genre);

}
