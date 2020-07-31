package model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {

	private static final long serialVersionUID = -3716503653339551014L;

	private int cartao;

	public int getCartao() {
		return cartao;
	}

	public void setCartao(int cartao) {
		this.cartao = cartao;
	}

}
