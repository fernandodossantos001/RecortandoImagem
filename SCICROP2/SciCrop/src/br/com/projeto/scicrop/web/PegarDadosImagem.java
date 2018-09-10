package br.com.projeto.scicrop.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.scicrop.excecao.Excecao;

@WebServlet(urlPatterns="/recortarImagem")
public class PegarDadosImagem extends HttpServlet {
	
	@Override
	protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caminhoImagem;
		String ondeSalvar;
		String formato;
		int largura;
		int altura;
		
		
		
		caminhoImagem = req.getParameter("caminhoImagem");		
		ondeSalvar = req.getParameter("ondeSalvar");
		formato = req.getParameter("formato");
		largura = Integer.parseInt(req.getParameter("width"));
		altura = Integer.parseInt(req.getParameter("height"));
		ondeSalvar+= formato;
		
		req.setAttribute("caminho",caminhoImagem);
		req.setAttribute("ondeSalvar", ondeSalvar);
		
		
		File caminhoImagemOriginal = new File(caminhoImagem);
		File ondeSalvarImagem = new File(ondeSalvar);
		
		
		try {
			RecortaImagem.recortar(caminhoImagemOriginal, ondeSalvarImagem, largura, altura, "jpg");
		}catch(Exception e) {
			if(Excecao.tratarExcecao(e).equals("N�o foi possivel ler o arquivo")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/erro.jsp");
				dispatcher.forward(req, resp);
			}

		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/geradoComSucesso.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	
	
	

	
}
