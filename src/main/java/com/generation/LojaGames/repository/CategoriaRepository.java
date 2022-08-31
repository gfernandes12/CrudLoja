package com.generation.LojaGames.repository;

public class CategoriaRepository {

	public boolean existsById(Object id) {
		// TODO Auto-generated method stub
		return false;
	}
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
	import javax.validation.constraints.NotBlank;

	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "tb_categorias")

	public class Categoria {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "Atributo Obrigatório")
		private String descricao;

		@OneToMany(mappedBy = "descricao", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("descricao")
		private List<Produto> produto;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public List<Produto> getProduto() {
			return produto;
		}

		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}
		
		

}
