
import destinations from '@/constants/destinations.json'
import Card from './Components/Card'

const Destinations = () => {
  return (
    <section className="destinations" id="destinations">
      <div className="titles">
        <div>
          <span>Destinos</span>
          <div className="wrapper">
            <h2>Escolha o seu destino</h2>
            <p>Tudo que você precisa saber!</p>
          </div>
        </div>
      </div>
      <ul>
        {destinations && destinations.map(destination => <Card data={destination} />)}
      </ul>
    </section>
  )
}

export default Destinations