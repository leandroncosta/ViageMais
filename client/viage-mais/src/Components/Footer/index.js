const Footer = () => {
  return (
    <footer>
      <div className="footer-nav">
        <article>
          <div className="wrapper-logo">
            <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/airplane.svg" alt="logo" className="logo" />
            <a className="navbar-brand" href="#">
              ViageMais
            </a>
          </div>
          <p>
            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Est
            consequatur nulla ipsum quos ea sequi et hic esse, omnis magni
            deleniti neque sit dicta. Delectus aliquam dolor ducimus doloremque
            ad!
          </p>
        </article>
        <div className="footer-info">
          <div className="contato">
            <h3>Contato</h3>
            <ul>
              <li>Central de atendimento</li>
              <li>viajeMais@gmail.com</li>
            </ul>
          </div>
          <div className="agencia">
            <h3>Agência</h3>
            <ul>
              <li>Sobre nós</li>
              <li>Cotar viagem</li>
              <li>Cotar Passagem</li>
              <li>Contato</li>
              <li>Blog</li>
            </ul>
          </div>
          <div className="top-destinos">
            <h3>Top Destinos</h3>
            <ul>
              <li>Paris</li>
              <li>Dubai</li>
              <li>Cancúm</li>
              <li>Caribe</li>
              <li>Nova York</li>
            </ul>
          </div>
        </div>
      </div>
      <div className="redes">
        <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/instagram.svg" alt="" />
        <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/facebook.svg" alt="" />
        <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/twitter.svg" alt="" />
      </div>
      <div className="copy">
        <p> © ViageMais - Todos os direitos reservados.</p>
        <div>
          <a href="">Cookies</a>
          <a href="">Política de privacidade</a>
          <a href="">Ajuda</a>
        </div>
      </div>
    </footer>
  )
}

export default Footer