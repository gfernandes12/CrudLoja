package com.generation.LojaGames.model;

public class Produto {

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Produto getCategoria() {
		// TODO Auto-generated method stub
		return null;
	}
	import javax.persistence.Entity;
port javax.persistence.GeneratedValue;
rt javax.persistence.GenerationType;


 javax.persistence.Id;
i
r
avax.persistence.ManyToOne;
im
t 
ax.persistence.Table;
imp
 ja
.validation.constraints.NotBlank;
impo
java
alidation.constraints.NotNull;
impor
avax.
idation.constraints.Size;

impo

m.fa

ml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "tb_produtos")
	public class Produto {

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "Atributo obrigatório")
		@Size(min = 5, max = 200)
		private String nome;
		
		@NotBlank(message = "mensagem obrigatória")
		@Size(min = 5, max = 1000)
		private String descricao;
		
		@NotNull
		private double preco;
		
		@NotNull
		private int quantidade;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		
		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
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
