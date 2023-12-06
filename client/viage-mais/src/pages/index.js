import Destinations from "@/Components/Sections/Destinations";
import Footer from "@/Components/Footer";
import Hotels from "@/Components/Sections/Hotels";
import Promotions from "@/Components/Sections/Promotions";


export default function Home() {
  return (
    <>
      <div className="container d-flex flex-column align-items-center min-vh-100">
        <Destinations />
        <Hotels />
        <Promotions />
        <section className="contact" id="contact"></section>
        <section className="about" id="about">
          <div className="titles">
            <div>
              <span>Sobre nós</span>
              <div className="wrapper">
                <h2>ViajeMais </h2>
                <p>Tudo que você precisa saber!</p>
              </div>
            </div>
          </div>
          <div className="sobre-detalhes">
            <article>
              <p>
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ratione
                voluptas possimus aspernatur. Et, harum vel reprehenderit rem
                architecto itaque quasi temporibus fuga fugit! Nulla adipisci ullam
                esse velit fugit officiis?
              </p>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Atque sint
                dolores ipsum excepturi fugiat quae, ipsam facilis, officiis vitae
                illum inventore libero repudiandae voluptatem. Numquam, harum omnis?
                Quam, delectus nam.
              </p>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo
                natus laboriosam ipsum!
              </p>
              <button>Saiba mais</button>
            </article>
            <figure>
              <div
                style={{
                  width: "100%",
                  height: 0,
                  paddingBottom: "56%",
                  position: "relative"
                }}
              >
                <iframe
                  src="https://giphy.com/embed/KGwTZd1qr8hsSKsrFI"
                  width="100%"
                  height="100%"
                  style={{ position: "absolute" }}
                  frameBorder={0}
                  className="giphy-embed"
                  allowFullScreen=""
                />
              </div>
              <p>
                <a href="https://giphy.com/gifs/nice-france-KGwTZd1qr8hsSKsrFI">
                  via GIPHY
                </a>
              </p>
            </figure>
          </div>
          <div className="feedback">
            <div className="details">
              <h3>125</h3>
              <span>Destinos</span>
            </div>
            <div className="details">
              <h3>999</h3>
              <span>Pacotes vendidos</span>
            </div>
            <div className="details">
              <h3>24000</h3>
              <span>Clientes satisfeitos</span>
            </div>
          </div>
        </section>
        <Footer />
      </div>

      {/* Menu libras */}
      <div vw="" className="enabled">
        <div vw-access-button="" className="active" />
        <div vw-plugin-wrapper="">
          <div className="vw-plugin-top-wrapper" />
        </div>
      </div>
    </>
  )
}
