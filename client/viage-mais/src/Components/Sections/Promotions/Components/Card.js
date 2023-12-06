import React from 'react'

const Card = ({ data }) => {
  return (
    <div className="card ">
      <div className="card-image ">
        <img src={data.imgUrl} alt="imagem {data.name}" />
      </div>
      <div className="card-content">
        <div className="hotel-name">
          <h3>{data.name}</h3>
        </div>
        <div>
          <span>Ida e volta | </span>
          <span>10 nov 2023 - 18 nov 2023</span>
          <span>9 dias</span>
        </div>
        <span className="price">A partir de R$ 999</span>
      </div>
    </div>
  )
}

export default Card