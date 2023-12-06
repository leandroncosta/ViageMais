import promotions from '@/constants/promotions.json';
import Card from './Components/Card';

const Promotions = () => {
    return (
        <section className="promotions" id="promotions">
            <div className="titles">
                <div>
                    <span>Promoções</span>
                    <div className="wrapper">
                        <h2>Promoções em alta</h2>
                        <p>Os mais procurados na última semana</p>
                    </div>
                </div>
            </div>
            <div className="cards">
                {promotions &&
                    promotions
                        .filter((item, index) => index < 3)
                        .map((promotion) => (
                            <Card key={promotion.name} data={promotion} />
                        ))}

                <div className="card">
                    <div className="card-image "></div>
                    <a href="/promocoes">
                        <div className="card-content">
                            <h3>Navegue por mais destinos em promoção</h3>
                            <div className="hotel-name">
                                <p>Ver mapa &gt;</p>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </section>
    );
};

export default Promotions;
