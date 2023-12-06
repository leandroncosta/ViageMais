const promocoes = () => {
  return (
    (
      <div className="container d-flex flex-column align-items-center min-vh-100">
        <section className="promotions" id="promotions">
          <div className="titles">
            <div>
              <span>Promoções</span>
              <div className="wrapper">
                <h2>Promoções em alta</h2>
              </div>
            </div>
          </div>
          <div className="cards">
            <div className="card ">
              <div className="card-image ">
                <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/buenos-aires.jpg" alt="buenos-aires" />
              </div>
              <div className="card-content">
                <div className="hotel-name">
                  <h3>Buenos Aires</h3>
                </div>
                <div>
                  <span>Ida e volta | </span>
                  <span>9 dias</span>
                </div>
                <span className="price">por R$ 999</span>
              </div>
              <div className="card-type ticket">Passagem</div>
            </div>
            <div className="card ">
              <div className="card-image ">
                <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/lisboa.webp" alt="lisboa" />
              </div>
              <div className="card-content">
                <div className="hotel-name">
                  <h3>Lisboa</h3>
                </div>
                <div>
                  <span>Ida e volta | </span>
                  <span>9 dias</span>
                </div>
                <span className="price">por R$ 999</span>
              </div>
              <div className="card-type ticket">Passagem</div>
            </div>
            <div className="card ">
              <div className="card-image ">
                <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/santiago.jpg" alt="santiago" />
              </div>
              <div className="card-content">
                <div className="hotel-name">
                  <h3>Santiago</h3>
                </div>
                <div>
                  <span>Ida e volta | </span>
                  <span>9 dias </span>
                </div>
                <span className="price">por R$ 999</span>
              </div>
              <div className="card-type ticket">Passagem</div>
            </div>
            <div className="card ">
              <div className="card-image ">
                <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/foziguacu.webp" alt="foziguacu" />
              </div>
              <div className="card-content">
                <div className="hotel-name">
                  <h3>Foz do Iguaçu</h3>
                </div>
                <div>
                  <span>30 nov 2023 - 8 dez 2023</span>
                </div>
                <span className="price">Pacotes a partir de R$ 999</span>
              </div>
              <div className="card-type package">Pacote</div>
            </div>
            <div className="card ">
              <div className="card-image ">
                <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/serra-gaucha.jpg" alt="serra-gaucha" />
              </div>
              <div className="card-content">
                <div className="hotel-name">
                  <h3>Serra gaúcha</h3>
                </div>
                <div>
                  <span>10 nov 2023 - 18 nov 2023</span>
                </div>
                <span className="price">Pacotes a partir de R$ 999</span>
              </div>
              <div className="card-type package">Pacote</div>
            </div>
            <div className="card ">
              <div className="card-image ">
                <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/parisjpg.jpg" alt="paris" />
              </div>
              <div className="card-content">
                <div className="hotel-name">
                  <h3>Paris</h3>
                </div>
                <div>
                  <span>30 nov 2023 - 8 dez 2023</span>
                </div>
                <span className="price">Pacotes a partir de R$ 999</span>
              </div>
              <div className="card-type package">Pacote</div>
            </div>
            <div className="card"></div>
          </div>
          <div className="promotions-info">
            <span>✓ Viaje conosco para seu lugar preferido</span>
            <span>✓ Parcelamento em até 12x</span>
            <span>✓ Segurança e confiança</span>
          </div>
        </section>
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
      </div>

    )
  )
}

export default promocoes