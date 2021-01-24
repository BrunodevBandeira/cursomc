package com.brunobandeira.cursomc.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brunobandeira.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
	
}
